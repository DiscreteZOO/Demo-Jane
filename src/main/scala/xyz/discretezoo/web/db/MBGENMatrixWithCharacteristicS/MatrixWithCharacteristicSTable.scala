package xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicS

import java.util.UUID
import slick.collection.heterogeneous.HNil
import slick.lifted.{ProvenShape, Rep}
import xyz.discretezoo.web.DynamicSupport.ColumnSelector
import xyz.discretezoo.web.ZooPostgresProfile.api._
import xyz.discretezoo.web.db.MBGENMatrixS.MatrixSTable

final class MatrixWithCharacteristicSTable(tag: Tag) extends Table[MatrixWithCharacteristicS](tag, "MBGEN_MATRIXWITHCHARACTERISTICS") with ColumnSelector {

    val tbMatrixS = TableQuery[MatrixSTable]

  def ID: Rep[UUID] = column[UUID]("ID", O.PrimaryKey)
  def matrixID: Rep[Option[UUID]] = column[Option[UUID]]("MATRIXID")
  def fkMatrixS = foreignKey("MBGEN_MATRIXS_FK", matrixID, tbMatrixS)(_.ID, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def positiveDefinite: Rep[Option[Boolean]] = column[Option[Boolean]]("POSITIVE_DEFINITE")

  def * : ProvenShape[MatrixWithCharacteristicS] = (
    ID ::
matrixID ::
positiveDefinite ::
      HNil
    ).mapTo[MatrixWithCharacteristicS]

  val select: Map[String, Rep[_]] = Map(
    "matrixID" -> this.matrixID,
    "positive_definite" -> this.positiveDefinite
  )

  val inCollection: Map[String, Rep[Boolean]] = Map(
    "ID" -> true
  )

}
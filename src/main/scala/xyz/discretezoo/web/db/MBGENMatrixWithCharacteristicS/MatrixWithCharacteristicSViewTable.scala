package xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicSView

import java.util.UUID
import slick.collection.heterogeneous.HNil
import slick.lifted.{ProvenShape, Rep}
import xyz.discretezoo.web.DynamicSupport.ColumnSelector
import xyz.discretezoo.web.ZooPostgresProfile.api._


final class MatrixWithCharacteristicSViewTable(tag: Tag) extends Table[MatrixWithCharacteristicSView](tag, "MBGEN_MATRIXWITHCHARACTERISTICSVIEW") with ColumnSelector {

  

  def ID: Rep[UUID] = column[UUID]("ID", O.PrimaryKey)
  def positiveDefinite: Rep[Option[Boolean]] = column[Option[Boolean]]("POSITIVE_DEFINITE")
  def mat: Rep[List[Int]] = column[List[Int]]("MAT")
  def trace: Rep[Option[Int]] = column[Option[Int]]("TRACE")
  def orthogonal: Rep[Option[Boolean]] = column[Option[Boolean]]("ORTHOGONAL")
  def eigenvalues: Rep[List[Int]] = column[List[Int]]("EIGENVALUES")

  def * : ProvenShape[MatrixWithCharacteristicSView] = (
    ID ::
positiveDefinite ::
mat ::
trace ::
orthogonal ::
eigenvalues ::
      HNil
    ).mapTo[MatrixWithCharacteristicSView]

  val select: Map[String, Rep[_]] = Map(
    "positive_definite" -> this.positiveDefinite,
    "mat" -> this.mat,
    "trace" -> this.trace,
    "orthogonal" -> this.orthogonal,
    "eigenvalues" -> this.eigenvalues
  )

  val inCollection: Map[String, Rep[Boolean]] = Map(
    "ID" -> true
  )

}
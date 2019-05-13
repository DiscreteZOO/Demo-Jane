package xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicS
import java.util.UUID
import xyz.discretezoo.web.ZooObject

case class MatrixWithCharacteristicS(
  ID: UUID,
  matrixID: Option[UUID],
  positiveDefinite: Option[Boolean]
) extends ZooObject {

  def select: Map[String, _] = Map(
    "matrixID" -> matrixID,
    "positive_definite" -> positiveDefinite
  )

}
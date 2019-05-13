package xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicSView
import java.util.UUID
import xyz.discretezoo.web.ZooObject

case class MatrixWithCharacteristicSView(
  ID: UUID,
  positiveDefinite: Option[Boolean],
  mat: List[Int],
  trace: Option[Int],
  orthogonal: Option[Boolean],
  eigenvalues: List[Int]
) extends ZooObject {

  def select: Map[String, _] = Map(
    "positive_definite" -> positiveDefinite,
    "mat" -> mat,
    "trace" -> trace,
    "orthogonal" -> orthogonal,
    "eigenvalues" -> eigenvalues
  )

}
package xyz.discretezoo.web.db.MBGENMatrixS
import java.util.UUID
import xyz.discretezoo.web.ZooObject

case class MatrixS(
  ID: UUID,
  mat: List[Int],
  trace: Option[Int],
  orthogonal: Option[Boolean],
  eigenvalues: List[Int]
) extends ZooObject {

  def select: Map[String, _] = Map(
    "mat" -> mat,
    "trace" -> trace,
    "orthogonal" -> orthogonal,
    "eigenvalues" -> eigenvalues
  )

}
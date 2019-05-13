package xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicS
import java.util.UUID
import slick.jdbc.GetResult
import xyz.discretezoo.web.PlainSQLSupport
import xyz.discretezoo.web.ZooPostgresProfile.api._

object MatrixWithCharacteristicSPlainQuery extends PlainSQLSupport[MatrixWithCharacteristicS] {

  override val columns: String =
    """
      |"MBGEN_MATRIXWITHCHARACTERISTICS"."ID",
      |"MBGEN_MATRIXWITHCHARACTERISTICS"."POSITIVE_DEFINITE"
    """.stripMargin
  override val from: String = "MBGEN_MATRIXWITHCHARACTERISTICS"
  override implicit val getResult: GetResult[MatrixWithCharacteristicS] = GetResult(r =>
    MatrixWithCharacteristicS(r.nextObject.asInstanceOf[UUID], None, r.<<)
  )

  val inCollection: Map[String, String] = Map(
    "MatrixWithCharacteristicS" -> "ID"
  )

}
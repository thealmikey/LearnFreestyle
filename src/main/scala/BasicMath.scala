import cats.Id
import freestyle._
import freestyle.implicits._

object BasicMath extends App{

  @free trait DoMath{
    def add(a:Int,b:Int):FS[Int]
    def multiply(a:Int, b:Int):FS[Int]
    def square(a:Int):FS[Int]
  }

  def myProg[F[_]](implicit A:DoMath[F])={
    import A._

    for{
      a <- add(2,3)
      b <- multiply(a,3)
      c <- square(b)
    } yield (c)

  }

  implicit val DoMathHandler = new DoMath.Handler[Id] {
    override def add(a: Int, b: Int): Id[Int] = {
      a+b
    }

    override def multiply(a: Int, b: Int): Id[Int] = {
      a*b
    }

    override def square(a: Int): Id[Int] = {
      a*a
    }
  }

  println(myProg[DoMath.Op].interpret[Id])

}
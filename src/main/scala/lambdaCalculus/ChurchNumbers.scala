package lambdaCalculus

object ChurchNumbers {

  type λ_T[T] = T => T

  type λ_λ_T[T] = λ_T[T] => T => T

  private def zero[T]: λ_λ_T[T] = (s: λ_T[T]) => (z: T) => z

  def one[T]: λ_λ_T[T] = (s: λ_T[T]) => (z: T) => s(z)

  def two[T]: λ_λ_T[T] = (s: λ_T[T]) => (z: T) => s(s(z))

  /**
    * Realizes "successor" operation, that adds a value to a number in Church numbers
    */
  def successor[T](n: λ_λ_T[T]): λ_λ_T[T] = (s: λ_T[T]) => (z: T) => s( n(s)(z) )

  /**
    * Realizes "addition" operation, that adds a number to another number in Church numbers
    */
  def addition[T](n: λ_λ_T[T])(m: λ_λ_T[T]): λ_λ_T[T] = (s: λ_T[T]) => (z: T) => m(s)( n(s)(z) )
  
  /**
    * Realizes "multiplication" operation, that multiplies a number with another number in Church numbers
    */
  def multiplication[T](n: λ_λ_T[T])(m: λ_λ_T[T]): λ_λ_T[T] = (s: λ_T[T]) => (z: T) => n(m(s))(z)


  def one_succ[T]: λ_λ_T[T] = successor(zero)

  def two_succ[T]: λ_λ_T[T] = successor(one)
}

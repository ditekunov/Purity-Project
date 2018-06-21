package lambdaCalculus

object PureLambdaCalculus {

  /**
    * Axiomatic types for lambda calculus
    */
  type λ_T[T] = T => T

  type λ_λ_T[T] = λ_T[T] => T => T

  type λ_λ_λ_T[T] = λ_λ_T[T] => λ_λ_T[T]

  /**
    * Basic Church numbers realised on basic abstractions
    */
  def zero[T]: λ_λ_λ_T[T] = (s: λ_λ_T[T]) => (z: λ_T[T]) => z

  def one[T]: λ_λ_λ_T[T] = (s: λ_λ_T[T]) => (z: λ_T[T]) => s(z)

  def two[T]: λ_λ_λ_T[T] = (s: λ_λ_T[T]) => (z: λ_T[T]) => s(s(z))

  /**
    * Realizes "successor" operation, that adds a value to a number in Church numbers
    */
  def successor[T](n: λ_λ_λ_T[T]): λ_λ_λ_T[T] = (s: λ_λ_T[T]) => (z: λ_T[T]) => s( n(s)(z) )

  /**
    * Realizes "addition" operation, that adds a number to another number in Church numbers
    */
  def addition[T](n: λ_λ_λ_T[T])(m: λ_λ_λ_T[T]): λ_λ_λ_T[T] = (s: λ_λ_T[T]) => (z: λ_T[T]) => n(s)( m(s)(z) )

  /**
    * Realizes "multiplication" operation, that multiplies a number with another number in Church numbers
    */
  def multiplication[T](n: λ_λ_λ_T[T])(m: λ_λ_λ_T[T]): λ_λ_λ_T[T] = (s: λ_λ_T[T]) => (z: λ_T[T]) => n(m(s))(z)


  def one_succ[T]: λ_λ_T[T] = successor(zero)

  def two_succ[T]: λ_λ_T[T] = successor(one)
}

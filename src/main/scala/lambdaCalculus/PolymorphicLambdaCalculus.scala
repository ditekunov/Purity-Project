package lambdaCalculus

object PolymorphicDataCalculus {

  /**
    * Basic types for polymorphic lambda calculus
    */
  type λ_Typed[T] = T => T => T

  type λ_λ_Typed[T] = λ_Typed[λ_Typed[T]]

  type λ_λ_λ_Typed[T] =  λ_λ_Typed[T] => λ_Typed[T] => λ_Typed[T]

  type λ_λ_λ_λ_Typed[T] = (λ_Typed[T]) => T => T


  /**
    * Boolean constants for polymorphic lambda calculus
    */
  def λtrue[T]: λ_Typed[T] = (s: T) => (z: T) => s

  def λfalse[T]: λ_Typed[T] = (s: T) => (z: T) => z


  /**
    * Boolean constants, realised via abstractions
    */
  def abstract_λtrue[T]: λ_Typed[T] = λnot(λfalse)

  def abstract_λfalse[T]: λ_Typed[T] = λnot(λtrue)


  /**
    * Boolean operators for polymorphic lambda calculus
    */
  def λif[T](p: λ_Typed[T]): λ_Typed[T] = (t: T) => (e: T) => p(t)(e)

  def λand[T](n: λ_λ_Typed[T])(m: λ_Typed[T]): λ_Typed[T] = n(m)(λfalse)

  def λor[T](n: λ_λ_Typed[T])(m: λ_Typed[T]): λ_Typed[T] = n(λtrue)(m)

  def λnot[T](n: λ_λ_Typed[T]): λ_Typed[T] = n(λfalse)(λtrue)


  /**
    * Realizes "pair" operation, that combines two numbers in polymorphic lambda calculus
    */
  def pair[T](a: λ_λ_Typed[T]): λ_λ_Typed[T] = (b: λ_Typed[T]) => (t: λ_Typed[T]) => a(b)(t)
  
  def first[T]: λ_λ_λ_Typed[T] = (p: λ_λ_Typed[T]) => p(λtrue)

  def second[T]: λ_λ_λ_Typed[T] = (p: λ_λ_Typed[T]) => p(λfalse)
  
}

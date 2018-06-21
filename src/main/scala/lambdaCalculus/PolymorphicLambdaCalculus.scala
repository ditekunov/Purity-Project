package lambdaCalculus

object PolymorphicLambdaCalculus {

  type λ_Typed[T] = T => T => T

  type λ_λ_Typed[T] = λ_Typed[λ_Typed[T]]

  def λtrue[T]: λ_Typed[T] = (s: T) => (z: T) => s
  
  def λfalse[T]: λ_Typed[T] = (s: T) => (z: T) => z

  def λif[T](p: λ_Typed[T]): λ_Typed[T] = (t: T) => (e: T) => p(t)(e)

  def λand[T](n: λ_λ_Typed[T])(m: λ_Typed[T]): λ_Typed[T] = n(m)(λfalse)

  def λor[T](n: λ_λ_Typed[T])(m: λ_Typed[T]): λ_Typed[T] = n(λtrue)(m)

  def λnot[T](n: λ_λ_Typed[T]): λ_Typed[T] = n(λfalse)(λtrue)
  
}

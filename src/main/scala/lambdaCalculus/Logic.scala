package lambdaCalculus

import lambdaCalculus.Numbers.{λ_T, λ_λ_T}

object Logic {

  def λfalse[T]: λ_λ_T[T] = (s: λ_T[T]) => (z: T) => z

  def λif[T](p: λ_λ_T[T]): λ_λ_T[T] = (t: λ_T[T]) => (e: T) => p(t)(e)
}

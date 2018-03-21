package functionalAlgorithms.miscellaneous

/**
  * Saves values of current element in foldLeft and count of changes of negative to positive and positive to negative
  */
case class CurrentAndPositiveNegativeCounters(current: Int = 0,
                                              counterOfPositiveToNegative: Int = 0,
                                              counterOfNegativeToPositive: Int = 0)

/**
  * Saves values of current element in foldLeft and count of changes of vowel to consonant and consonant to vowel
  */
case class CurrentAndVowelConsonantCounters(current: Char = '\0',
                                            counterOfVowelToConsonant: Int = 0,
                                            counterOfConsonantToVowel: Int = 0)



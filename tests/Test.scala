object TestRunner {
  def main(args: Array[String]): Unit = {
    val signalcase_1 = Signal(92, 80, 16, 20, 6)
    assert(Policy.score(signalcase_1) == 150)
    assert(Policy.classify(signalcase_1) == "review")
    val signalcase_2 = Signal(82, 105, 24, 13, 5)
    assert(Policy.score(signalcase_2) == 146)
    assert(Policy.classify(signalcase_2) == "review")
    val signalcase_3 = Signal(96, 102, 21, 22, 8)
    assert(Policy.score(signalcase_3) == 162)
    assert(Policy.classify(signalcase_3) == "accept")
  }
}

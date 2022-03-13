import kotlin.concurrent.timer
import kotlin.random.Random

fun randomCounter() {
    timer(period = 100L) {
        if (Random.nextDouble() > 0.5) {
            logger.info("counted")
            randomCounter.increment()
        }
    }
}
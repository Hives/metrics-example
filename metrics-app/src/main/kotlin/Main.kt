import io.micrometer.core.instrument.Counter
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val meterRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
val randomCounter: Counter = meterRegistry.counter("random.counter")
val logger: Logger = LoggerFactory.getLogger("metrics test")

const val metricsPort = 8081

fun main() {
    logger.info("starting metrics server on port $metricsPort")

    metricsEndpoint(meterRegistry)
        .asServer(Jetty(metricsPort))
        .start()

    randomCounter()
}
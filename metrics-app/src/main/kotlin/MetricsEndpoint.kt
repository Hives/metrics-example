import io.micrometer.prometheus.PrometheusMeterRegistry
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes

fun metricsEndpoint(
    metrics: PrometheusMeterRegistry
): RoutingHttpHandler = routes(
    "/prometheus" bind Method.GET to {
        Response(Status.OK).body(metrics.scrape())
    }
)

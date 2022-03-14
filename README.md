# Micrometer / Prometheus / Grafana example

## Running it

### 1. Start Kotlin application

```
$ cd metrics-app
$ ./gradlew run
```

This starts some processes to generate dummy metrics, and exposes a metrics
endpoint on http://localhost:8081/prometheus

### 2. Start Prometheus

Install Prometheus using instructions [here][prometheus-getting-started].

Start prometheus with the config file included in this project:

```
$ /path/to/prometheus --config.file=/path/to/this/project/prometheus.yml
```

This configures it to scrape the metrics endpoint of the Kotlin application.

When it's running you can view Prometheus in your browser on
http://localhost:9090

Try clicking on the graph tab, entering a query like
`rate(random_counter_total[1m])` and clicking `Execute`

### 3. Start Grafana

Install and start Grafana using instructions [here][install-grafana].

On Linux you can start it up and verify that the service has started with:

```
$ sudo systemctl daemon-reload
$ sudo systemctl start grafana-server
$ sudo systemctl status grafana-server
// to stop it afterwards:
$ sudo systemctl stop grafana-server
```

Open Grafana in the browser at http://localhost:3000

[prometheus-getting-started]: https://prometheus.io/docs/prometheus/latest/getting_started/
[install-grafana]: https://grafana.com/docs/grafana/latest/installation/

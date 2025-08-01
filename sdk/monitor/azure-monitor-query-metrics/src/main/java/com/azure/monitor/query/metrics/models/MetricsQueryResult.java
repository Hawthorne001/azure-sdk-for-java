// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.monitor.query.metrics.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import com.azure.monitor.query.metrics.implementation.MonitorQueryMetricsUtils;

/**
 * The response to a metrics query.
 */
@Immutable
public final class MetricsQueryResult {

    private final Integer cost;
    private final MetricsQueryTimeInterval timeInterval;
    private final Duration granularity;
    private final String namespace;
    private final String resourceRegion;
    private final List<MetricResult> metrics;

    private String resourceId;

    static {
        MonitorQueryMetricsUtils.setMetricsQueryResultAccessor(MetricsQueryResult::setResourceId);
    }

    /**
     * Creates an instance of the response to a metrics query.
     * @param cost the integer value representing the cost of the query, for data case.
     * @param timeInterval the time interval for which the data was retrieved.
     * @param granularity the interval (window size) for which the metric data was returned in.
     * @param namespace the namespace of the metrics been queried.
     * @param resourceRegion the region of the resource been queried for metrics.
     * @param metrics the value of the collection.
     */
    public MetricsQueryResult(Integer cost, MetricsQueryTimeInterval timeInterval, Duration granularity,
        String namespace, String resourceRegion, List<MetricResult> metrics) {
        this.cost = cost;
        this.timeInterval = timeInterval;
        this.granularity = granularity;
        this.namespace = namespace;
        this.resourceRegion = resourceRegion;
        this.metrics = metrics;
    }

    /**
     * Returns the integer value representing the cost of the query, for data case.
     * @return the integer value representing the cost of the query, for data case.
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Returns the time interval for which the data was retrieved.
     * @return the time interval for which the data was retrieved.
     */
    public MetricsQueryTimeInterval getTimeInterval() {
        return timeInterval;
    }

    /**
     * Returns the interval (window size) for which the metric data was returned in.
     * @return the interval (window size) for which the metric data was returned in.
     */
    public Duration getGranularity() {
        return granularity;
    }

    /**
     * Returns the namespace of the metrics being queried
     * @return the namespace of the metrics being queried
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Returns the region of the resource being queried for metrics.
     * @return the region of the resource being queried for metrics.
     */
    public String getResourceRegion() {
        return resourceRegion;
    }

    /**
     * Returns the value of the collection.
     * @return the value of the collection.
     */
    public List<MetricResult> getMetrics() {
        return metrics;
    }

    /**
     * Returns the resource id of the resource this metrics result belongs to.
     * @return the resource id of the resource this metrics result belongs to.
     */
    public String getResourceId() {
        return resourceId;
    }

    private void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * Returns the metric result for the {@code metricName}.
     *
     * @param metricName The name of the metric to look up the result for.
     * @return The {@link MetricResult} for {@code metricName} if found, {@code null} otherwise.
     */
    public MetricResult getMetricByName(String metricName) {
        Objects.requireNonNull(metricName, "'metricName' cannot be null");
        if (CoreUtils.isNullOrEmpty(metrics)) {
            return null;
        }

        return metrics.stream()
            .filter(metricResult -> metricResult.getMetricName().equals(metricName))
            .findFirst()
            .orElse(null);
    }
}

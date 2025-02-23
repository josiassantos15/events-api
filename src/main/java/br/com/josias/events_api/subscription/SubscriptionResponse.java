package br.com.josias.events_api.subscription;

public record SubscriptionResponse(
        Integer subscriptionNumber,
        String designation
) {
}
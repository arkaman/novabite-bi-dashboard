export function formatCurrency(value: number) {
    return new Intl.NumberFormat("en-IN", {
        style: "currency",
        currency: "INR",
        maximumFractionDigits: 2,
    }).format(value);
}

export function formatPercentage(value: number) {
    return `${value.toFixed(2)}%`;
}
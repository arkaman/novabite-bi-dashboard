import { KpiCard } from "@/components/KpiCard";
import { useSummary } from "@/hooks/useSummary";
import { formatCurrency, formatPercentage } from "@/lib/format";

export function App() {
  const { data, isLoading, error } = useSummary();

  if (isLoading) {
    return (
      <div className="p-8 text-muted-foreground">
        Loading dashboard...
      </div>
    );
  }

  if (error || !data) {
    return (
      <div className="p-8 text-destructive">
        Failed to load dashboard.
      </div>
    );
  }

  return (
    <main className="min-h-screen bg-background">
      <div className="container mx-auto max-w-7xl space-y-8 p-6">
        <header className="space-y-1">
          <h1 className="text-3xl font-bold tracking-tight">
            NovaBite BI Dashboard
          </h1>

          <p className="text-muted-foreground">
            AI-powered business insights for sales managers
          </p>
        </header>

        <section className="grid gap-4 md:grid-cols-3">
          <KpiCard
            title="Total Net Revenue"
            value={formatCurrency(data.totalNetRevenue)}
          />

          <KpiCard
            title="Gross Profit Margin"
            value={formatPercentage(data.grossProfitMargin)}
          />

          <KpiCard
            title="Top Region"
            value={data.topRegion}
          />
        </section>

        <section className="rounded-xl border p-6">
          <h2 className="mb-4 text-lg font-semibold">
            Monthly Revenue Trend
          </h2>

          <div className="flex h-80 items-center justify-center rounded-lg border border-dashed text-muted-foreground">
            Revenue Chart
          </div>
        </section>

        <section className="rounded-xl border p-6">
          <h2 className="mb-4 text-lg font-semibold">
            AI Business Assistant
          </h2>

          <div className="flex h-64 items-center justify-center rounded-lg border border-dashed text-muted-foreground">
            Chat Interface
          </div>
        </section>
      </div>
    </main>
  );
}

export default App;
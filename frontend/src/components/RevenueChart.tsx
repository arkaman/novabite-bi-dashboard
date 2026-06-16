import {
    CartesianGrid,
    Line,
    LineChart,
    ResponsiveContainer,
    Tooltip,
    XAxis,
    YAxis,
} from "recharts";

import type { TrendResponse } from "@/types/api";

interface RevenueChartProps {
    data: TrendResponse[];
}

export function RevenueChart({ data }: RevenueChartProps) {
    return (
        <ResponsiveContainer width="100%" height={320}>
            <LineChart data={data}>
                <CartesianGrid strokeDasharray="3 3" />

                <XAxis dataKey="month" />

                <YAxis />

                <Tooltip />

                <Line
                    type="monotone"
                    dataKey="netRevenue"
                    strokeWidth={2}
                />
            </LineChart>
        </ResponsiveContainer>
    );
}
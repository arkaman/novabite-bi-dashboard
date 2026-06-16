import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";

interface KpiCardProps {
    title: string;
    value: string | number;
    subtitle?: string;
}

export function KpiCard({
    title,
    value,
    subtitle,
}: KpiCardProps) {
    return (
        <Card>
            <CardHeader className="pb-2">
                <CardTitle className="text-sm font-medium text-muted-foreground">
                    {title}
                </CardTitle>
            </CardHeader>

            <CardContent>
                <div className="text-3xl font-bold">
                    {value}
                </div>

                {subtitle && (
                    <p className="mt-2 text-sm text-muted-foreground">
                        {subtitle}
                    </p>
                )}
            </CardContent>
        </Card>
    );
}
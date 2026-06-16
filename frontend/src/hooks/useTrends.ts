import { useQuery } from "@tanstack/react-query";
import { getTrends } from "@/api/dashboard";

export function useTrends() {
    return useQuery({
        queryKey: ["trends"],
        queryFn: getTrends,
    });
}
import { api } from "@/lib/api";
import type {
    SummaryResponse,
    ProductResponse,
    TrendResponse,
} from "@/types/api";

export async function getSummary() {
    const { data } = await api.get<SummaryResponse>("/summary");
    return data;
}

export async function getProducts() {
    const { data } = await api.get<ProductResponse[]>("/products");
    return data;
}

export async function getTrends() {
    const { data } = await api.get<TrendResponse[]>("/trends");
    return data;
}
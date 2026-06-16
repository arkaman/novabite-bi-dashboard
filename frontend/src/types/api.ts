export interface SummaryResponse {
    totalNetRevenue: number;
    totalUnitsSold: number;
    grossProfitMargin: number;
    topRegion: string;
    topChannel: string;
    topProduct: string;
}

export interface ProductResponse {
    productName: string;
    totalNetRevenue: number;
    totalUnitsSold: number;
}

export interface TrendResponse {
    month: string;
    netRevenue: number;
}

export interface ChatRequest {
    question: string;
}

export interface ChatResponse {
    answer: string;
}
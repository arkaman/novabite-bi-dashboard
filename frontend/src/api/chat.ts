import { api } from "@/lib/api";
import type {
    ChatRequest,
    ChatResponse,
} from "@/types/api";

export async function askQuestion(question: string) {
    const payload: ChatRequest = {
        question,
    };

    const { data } = await api.post<ChatResponse>(
        "/chat",
        payload
    );

    return data;
}
import { useState } from "react";

import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { askQuestion } from "@/api/chat";

export function ChatBox() {
    const [question, setQuestion] = useState("");
    const [answer, setAnswer] = useState("");
    const [loading, setLoading] = useState(false);

    async function handleAsk() {
        if (!question.trim()) return;

        setLoading(true);

        try {
            const res = await askQuestion(question);
            setAnswer(res.answer);
        } finally {
            setLoading(false);
        }
    }

    return (
        <div className="space-y-4">
            <div className="flex gap-2">
                <Input
                    value={question}
                    onChange={(e) => setQuestion(e.target.value)}
                    placeholder="Ask a business question..."
                />

                <Button
                    onClick={handleAsk}
                    disabled={loading}
                >
                    {loading ? "Thinking..." : "Ask"}
                </Button>
            </div>

            <div className="rounded-lg border p-4 min-h-32 whitespace-pre-wrap">
                {answer || "Response will appear here."}
            </div>
        </div>
    );
}
import { ArrowRight } from "phosphor-react";
import { Logo } from "../components/Logo";

export function Home() {
    return (
        <main>
            <div className="flex flex-col items-center justify-center h-screen bg-brandCream-500">
                <header>
                    <Logo />
                    <h2 className="text-xs mb-5">Gerencie suas tarefas com agilidade.</h2>
                </header>
                <a href="/tasks" >
                    <button className="flex items-center bg-brandGreen-500 justify-center px-8 py-3 rounded-lg hover:bg-brandGreen-600 transition-colors">
                        <span className="font-bold">Começar agora</span>
                        <ArrowRight size={32} className="relative left-4" />
                    </button>
                </a>
            </div>
        </main>
    )
}
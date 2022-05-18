import { Plus } from "phosphor-react";
import { Logo } from "../components/Logo";
import { Task } from "../components/Task";

export function Tasks() {
    return (
        <main className="h-screen bg-brandCream-500">
            <div className="flex flex-col items-center justify-start">
                <header className="my-7">
                    <Logo />
                </header>
                <div id="tasks-container" className="w-2/4">
                    <div id="new-task"
                        className="flex flex-col items-center mb-5"
                    >
                        <button className="bg-brandGreen-500 p-2 self-end rounded-lg h-12 w-12 mb-7 hover:bg-brandGreen-600 transition-colors">
                            <Plus size={32} />
                        </button>
                        <input
                            placeholder="Digite sua tarefa aqui..."
                            type="text"
                            name="new-content"
                            id="new-content"
                            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0"
                        />
                    </div>
                    <div
                        id="task-list"
                        className="flex flex-col items-center gap-5"
                    >
                        <Task key="f8b9c3b4-e70d-4d76-896a-fdee1e235fc4" content="Fazer compras para cozinhar o jantar" isDone={false} />
                        <Task key="f2a92ddc-e710-4a0a-a3a5-881d79067d97" content="Colocar comida para os gatos" isDone={false} />
                        <Task key="ded672f5-d6da-45ae-9cde-a4d32db0112d" content="Tarefa realizada" isDone={true} />
                    </div>
                </div>
            </div>
        </main>
    )
}
import { CheckSquare, PencilSimple, Plus, Trash } from "phosphor-react";
import { Logo } from "../components/Logo";

export function Tasks() {
    return (
        <main className="h-screen bg-brandCream-500">
            <div className="flex flex-col items-center justify-start">
                <header className="my-7">
                    <Logo />
                </header>
                <div id="tasks" className="w-1/3">
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
                        <span
                            id="f8b9c3b4-e70d-4d76-896a-fdee1e235fc4"
                            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between"
                        >
                            Fazer compras para cozinhar o jantar
                            <div id="actions" className="flex">
                                <button className="hover:text-brandBlue">
                                    <PencilSimple size={32} />
                                </button>
                                <button className="hover:text-brandGreen-600">
                                    <CheckSquare size={32} />
                                </button>
                            </div>
                        </span>
                        <span
                            id="f2a92ddc-e710-4a0a-a3a5-881d79067d97"
                            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between">
                            Colocar comida para os gatos
                            <div id="actions" className="flex">
                                <button className="hover:text-brandBlue">
                                    <PencilSimple size={32} />
                                </button>
                                <button className="hover:text-brandGreen-600">
                                    <CheckSquare size={32} />
                                </button>
                            </div>
                        </span>
                        <span
                            id="ded672f5-d6da-45ae-9cde-a4d32db0112d"
                            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between">
                            <span className="text-zinc-400 line-through">
                                Tarefa realizada
                            </span>
                            <div id="actions" className="flex">
                                <button className="hover:text-brandRed">
                                    <Trash size={32} />
                                </button>
                            </div>
                        </span>
                    </div>
                </div>
            </div>
        </main>
    )
}
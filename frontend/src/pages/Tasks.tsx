import axios from "axios";
import { Plus } from "phosphor-react";
import { useEffect, useState } from "react";
import { Logo } from "../components/Logo";
import { Task } from "../components/Task";

const baseURL = "http://localhost:8080/todos"

export function Tasks() {
    const [tasks, setTasks] = useState([])
    const [newTask, setNewTask] = useState('')

    function handleDoneTask(id: string) {
        axios.patch(baseURL + `/${id}/alternar`).then(() => {
            getTasksFromApi()
        })
    }

    function handleDeleteTask(id: string) {
        axios.delete(baseURL + `/${id}`).then(() => {
            getTasksFromApi()
        })
    }

    function getTasksFromApi() {
        axios.get(baseURL).then(response => {
            setTasks(response.data)
        })
    }

    function handleTaskCreation() {
        axios.post(baseURL, {
            descricao: newTask
        }).then(() => {
            setNewTask('')
            getTasksFromApi()
        })
    }

    useEffect(() => {
        getTasksFromApi()
    }, [])

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
                        <button
                            className="bg-brandGreen-500 p-2 self-end rounded-lg h-12 w-12 mb-7 hover:bg-brandGreen-600 transition-colors"
                            onClick={() => handleTaskCreation()}
                        >
                            <Plus size={32} />
                        </button>
                        <input
                            placeholder="Digite sua tarefa aqui..."
                            type="text"
                            name="new-content"
                            id="new-content"
                            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0"
                            onInput={(event) => setNewTask(event.target.value)}
                            value={newTask}
                        />
                    </div>
                    <div
                        id="task-list"
                        className="flex flex-col items-center gap-5"
                    >
                        {tasks && tasks.map(task => {
                            return <Task
                                key={task.id}
                                content={task.descricao}
                                isDone={task.concluido}
                                markTaskAsDone={() => handleDoneTask(task.id)}
                                deleteDoneTask={() => handleDeleteTask(task.id)} />
                        })}
                    </div>
                </div>
            </div>
        </main>
    )
}
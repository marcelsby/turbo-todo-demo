import { TaskDone } from "./TaskDone"
import { TaskPendent } from "./TaskPendent"

export interface TaskProps {
    content: string,
    isDone: boolean,
    markTaskAsDone: () => void,
    deleteDoneTask: () => void
}

export interface TaskPendentProps {
    content: string,
    markTaskAsDone: () => void,
}

export interface TaskDoneProps {
    content: string,
    deleteTask: () => void
}

export function Task({ content, isDone, markTaskAsDone, deleteDoneTask }: TaskProps) {
    return (
        isDone ? <TaskDone content={content} deleteTask={deleteDoneTask} /> : <TaskPendent content={content} markTaskAsDone={markTaskAsDone} />
    )
}
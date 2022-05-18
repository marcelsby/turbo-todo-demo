import { TaskDone } from "./TaskDone"
import { TaskPendent } from "./TaskPendent"

export interface TaskProps {
    content: string,
    isDone: boolean
}

export interface SpecificTaskProps {
    content: string,
}

export function Task({ content, isDone }: TaskProps) {
    return (
        isDone ? <TaskDone content={content} /> : <TaskPendent content={content} />
    )
}
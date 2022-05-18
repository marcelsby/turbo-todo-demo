import { TaskDone } from "./TaskDone"
import { TaskPendent } from "./TaskPendent"

export interface TaskProps {
    key: string,
    content: string,
    isDone?: boolean
}

export function Task({ key, content, isDone }: TaskProps) {
    return (
        isDone ? <TaskDone key={key} content={content} /> : <TaskPendent key={key} content={content} />
    )
}
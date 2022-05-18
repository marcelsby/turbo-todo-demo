import { Trash } from "phosphor-react";
import { TaskDoneProps } from ".";

export function TaskDone({ content, deleteTask }: TaskDoneProps) {
    return (
        <span
            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between">
            <span className="text-zinc-400 line-through">
                {content}
            </span>
            <div id="actions" className="flex">
                <button className="hover:text-brandRed" onClick={deleteTask}>
                    <Trash size={32} />
                </button>
            </div>
        </span>
    )
}
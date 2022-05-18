import { Trash } from "phosphor-react";
import { TaskProps } from ".";

export function TaskDone({ key, content }: TaskProps) {
    return (
        <span
            id={key}
            className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between">
            <span className="text-zinc-400 line-through">
                {content}
            </span>
            <div id="actions" className="flex">
                <button className="hover:text-brandRed">
                    <Trash size={32} />
                </button>
            </div>
        </span>
    )
}
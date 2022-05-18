import { CheckSquare, PencilSimple } from "phosphor-react";
import { TaskProps } from ".";

export function TaskPendent({ key, content }: TaskProps) {
    return (
        <>
            <span
                id={key}
                className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between"
            >
                {content}
                <div id="actions" className="flex">
                    <button className="hover:text-brandBlue">
                        <PencilSimple size={32} />
                    </button>
                    <button className="hover:text-brandGreen-600">
                        <CheckSquare size={32} />
                    </button>
                </div>
            </span>
        </>
    )
}
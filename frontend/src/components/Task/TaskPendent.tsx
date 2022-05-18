import { CheckSquare, PencilSimple } from "phosphor-react";
import { TaskPendentProps } from ".";

export function TaskPendent({ content, markTaskAsDone }: TaskPendentProps) {
    return (
        <>
            <span
                className="p-3 rounded-lg shadow-md w-full bg-brandCream-400 outline-0 flex items-center justify-between"
            >
                {content}
                <div id="actions" className="flex">
                    {/* <button className="hover:text-brandBlue">
                        <PencilSimple size={32} />
                    </button> */}
                    <button className="hover:text-brandGreen-600" onClick={markTaskAsDone}>
                        <CheckSquare size={32} />
                    </button>
                </div>
            </span>
        </>
    )
}
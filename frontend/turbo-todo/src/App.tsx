import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './global.css'
import { Home } from './pages/Home'
import { Tasks } from './pages/Tasks'

export function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/tasks" element={<Tasks />} />
            </Routes>
        </BrowserRouter>
    )
}
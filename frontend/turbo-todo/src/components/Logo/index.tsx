import './logo.css'
import LightningSvg from '../../assets/lightning.svg'

export function Logo() {
    return (
        <div id="logo" className="flex gap-2">
            <div id="logo-text">
                <h1>TURBO</h1>
                <h1>TO DO</h1>
            </div>
            <img id="logo-svg" src={LightningSvg} alt="Imagem de um raio" />
        </div>
    )
}
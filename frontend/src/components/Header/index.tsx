import logo from '../../assets/img/ESTILO_DRIFT.png'
import './style.css'

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="DSMeta" />
                <h1>Estilo Drift Customs</h1>
                {/*
                <p>
                    Desenvolvido por
                    <a href="https://www.instagram.com/vinicius.tomazin/">@vincius.tomazin</a>
                </p>*/}
            </div>
        </header>
    )
}

export default Header
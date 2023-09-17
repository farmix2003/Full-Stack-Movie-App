import ReactPlayer from "react-player"
import { useParams } from "react-router-dom"

const Trailer = () => {

    let { ytTrailedId } = useParams()
    return (
        <div className="react-player-container" style={{ height: "90vh" }}>
            {(ytTrailedId != null) ? <ReactPlayer controls="true" url={`https://www.youtube.com/watch?v=${ytTrailedId}`}
                playing={true} width={"100%"} height={"100%"} /> : <h3>No video available</h3>}
        </div>
    )
}

export default Trailer
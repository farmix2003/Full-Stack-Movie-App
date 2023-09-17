import { Route, Routes } from 'react-router-dom';
import './App.css';
import api from './api/axiosConfig'
import { useState, useEffect } from 'react';
import Layout from './components/Layout';
import Home from './components/home/Home';
import Header from './components/navbar/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/reviews/Reviews';
function App() {
  const [movies, setMovies] = useState([])
  const [movie, setMovie] = useState()
  const [reviews, setReviews] = useState([])
  const getMovies = async () => {
    try {
      const response = await api.get("/movies")
      setMovies(response.data)
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  }
  useEffect(() => {
    getMovies()
  }, [])
  const getMovieData = async (movieId) => {
    try {
      const response = await api.get(`/movies/${movieId}`);
      const singleMovie = response.data;

      // Check if setReviews is an array before setting it
      if (Array.isArray(singleMovie.setReviews)) {
        setReviews(singleMovie.setReviews);
      } else {
        setReviews([]); // Set an empty array if it's not iterable
      }
      setMovie(singleMovie);
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path='/' index element={<Home movies={movies} />} />
        <Route path='/' element={<Layout />} />
        <Route path='/Trailer/:ytTrailedId' element={<Trailer />} />
        <Route path='/Reviews/:movieId' element={<Reviews getMovieData={getMovieData} movie={movie} reviews={reviews} setReviews={setReviews} />} />
      </Routes>
    </div>
  );
}

export default App;

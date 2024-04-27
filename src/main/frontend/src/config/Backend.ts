import axios from "axios";
import LoginDTO from "../dtos/LoginDTO";
import UserDTO from "../dtos/UserDTO";
import LiveScoreRequestDTO from "../dtos/LiveScoreRequestDTO";
import StudentDTO from "../dtos/StudentDTO";
import FacultyDTO from "../dtos/FacultyDTO";
import AdminDTO from "../views/Admin";

const Backend = {
  Auth: {
    login: (data: LoginDTO) =>
      axios.post(process.env.REACT_APP_LOGIN_API_PATH_POST!, data),
    registration: (data: UserDTO) =>
      axios.post(process.env.REACT_APP_REGISTRATION_API_PATH_POST!, data),
  },

  LiveScore: {
    list: (data: LiveScoreRequestDTO) =>
      axios.post(process.env.REACT_APP_LIVE_SCORE_LIST_API_PATH_POST!, {
        ...data,
        pageNumber: data.pageNumber - 1,
      }),
  },

  StudentRank :{
      list: () =>
          axios.get(process.env.REACT_APP_STUDENT_ALL_API_PATH_GET!),
      update: (data:StudentDTO) =>
          axios.put(process.env.REACT_APP_STUDENT_UPDATE_API_PATH_PUT!,data),
      getDetails:(data:StudentDTO)=>
          axios.post(process.env.REACT_APP_STUDENT_DETAILS_API_PATH_POST!,data),
  },

  FacultyList :{
      list: () =>
          axios.get(process.env.REACT_APP_FACULTY_ALL_API_PATH_GET!),
      update: (data:FacultyDTO) =>
          axios.put(process.env.REACT_APP_FACULTY_UPDATE_API_PATH_PUT!,data),
  },

    AdminList :{
        list: () =>
            axios.get(process.env.REACT_APP_ADMIN_ALL_API_PATH_GET!),
    }
};
export default Backend;

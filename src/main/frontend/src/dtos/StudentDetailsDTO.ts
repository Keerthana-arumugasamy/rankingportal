import StudentDTO from "./StudentDTO";
import LevelResponseDTO from "./LevelResponseDTO";
import StageResponseDTO from "./StageResponseDTO";

export default interface StudentDetailsDTO {
   studentResponse : StudentDTO,
   levelList : LevelResponseDTO[],
   stageList : StageResponseDTO[],
}

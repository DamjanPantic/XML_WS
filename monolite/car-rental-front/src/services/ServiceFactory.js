import VehicleService from './VehicleService';
import AuthService from './AuthService';
import CommentService from './CommentService';
import GradeService from './GradeService';


const vehicleService = new VehicleService();
const authService = new AuthService();
const gradeService = new GradeService();
const commentService = new CommentService();


const services = {
    vehicle: vehicleService,
    auth: authService,
    comment: commentService,
    grade: gradeService
};

export const ServiceFactory = {
    get: name => services[name]
};
import VehicleService from './VehicleService';
import AuthService from './AuthService';
import ReportService from './ReportService';
import CommentService from './CommentService';
import GradeService from './GradeService';


const vehicleService = new VehicleService();
const authService = new AuthService();
const gradeService = new GradeService();
const commentService = new CommentService();
const reportService = new ReportService();


const services = {
    vehicle: vehicleService,
    auth: authService,
    report: reportService,
    comment: commentService,
    grade: gradeService
};

export const ServiceFactory = {
    get: name => services[name]
};
import axios from "axios";

export default {
    getClothingList() {
        return axios.get('/closet');
    },

    deleteClothingItem(itemId) {
        return axios.delete(`/closet/${itemId}`);
    } 
}
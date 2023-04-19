import axios from "axios";

export default {
    getClothingList() {
        return axios.get('/closet');
    },

    deleteClothingItem(itemId) {
        return axios.delete(`/closet/${itemId}`);
    },

    getTypes() {
        return axios.get('/types');
    },

    addClothingItem(clothingItem) {
        return axios.post('/closet', clothingItem);
    },

    updateClothingItem(clothingItem) {
        return axios.put(`/closet/${clothingItem.id}`, clothingItem);
    },

    getColors() {
        return axios.get('/colors');
    }
}
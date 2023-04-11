import axios from "axios";

export default {
addOutfit(clothesList){
    return axios.post('/outfits', clothesList);
},
getOutfits(){
    return axios.get('/outfits');
},
getOutfitById(id){
    return axios.get(`/outfits/${id}`);
}
}
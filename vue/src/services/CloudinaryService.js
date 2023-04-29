
const api_key = '417594917384528';



export default {


    makeFromImgUrl(dataUri, uniqueId){
        const formData = new FormData();
        const file = dataUri

        formData.append('file', file);
        formData.append('upload_preset', 'ml_default');
        formData.append('public_id', uniqueId);
        formData.append('api_key', api_key);

       const url = "https://api.cloudinary.com/v1_1/dlnxljpbd/image/upload";

        return fetch(url, {
          method: "POST",
        body: formData});
    }
}
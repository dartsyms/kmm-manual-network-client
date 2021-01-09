import SwiftUI
import AsyncImageLoader
import shared

struct RecipeRow: View {
    @ObservedObject var viewModel: RecipeRowViewModel
    
    init(viewModel: RecipeRowViewModel) {
        self.viewModel = viewModel
    }
    var body: some View {
        let url = URL(string: viewModel.recipe.imgUrl ?? "https://picsum.photos/200")!
        
        HStack(alignment: .center) {
            AsyncImage(url: url, placeholder: { Image(systemName: "photo") }, image: { Image(uiImage: $0).resizable() })
                .aspectRatio(contentMode: .fit)
                .frame(width: 60)
                .clipShape(Circle())
                .overlay(Circle().stroke(Color.gray, lineWidth: 2))
                .padding(.all, 10)
            
            VStack(alignment: .leading) {
                Text(viewModel.recipe.title ?? "Unnamed recipe")
                    .font(.system(size: 16, weight: .bold, design: .default))
                    .lineLimit(2)
                    .foregroundColor(.primary)
                Text(viewModel.recipe.ingredients ?? "")
                    .font(.system(size: 10, weight: .medium, design: .default))
                    .lineLimit(4)
                    .foregroundColor(.secondary)
                
            }.padding(.trailing, 20)
            Spacer()
        }
        .frame(maxWidth: .infinity, alignment: .center)
        .background(Color(.systemBackground))
    }
}

struct RecipeRow_Previews: PreviewProvider {
    static var previews: some View {
        RecipeRow(viewModel: RecipeRowViewModel(recipe: Recipe(title: "", href: "", ingredients: "", imgUrl: "")))
    }
}
